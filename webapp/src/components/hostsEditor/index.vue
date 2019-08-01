<template>
  <div class='json-editor'>
    <textarea ref='textarea'></textarea>
  </div>
</template>

<script>
  import CodeMirror from 'codemirror';
  import 'codemirror/lib/codemirror.css';
  import modeHosts from './cm_hl'

  modeHosts()
  export default {
    name: 'hostsEditor',
    data() {
      return {
        jsonEditor: false,
        search_kw: '10',
      }
    },
    props: ['value'],
    watch: {
      value(value) {
        const editor_value = this.jsonEditor.getValue();
        if (value !== editor_value) {
          this.jsonEditor.setValue(value);
        }
      }
    },
    mounted() {
      this.jsonEditor = CodeMirror.fromTextArea(this.$refs.textarea, {
        lineNumbers: true,
        mode: 'hosts',
        //gutters: ['CodeMirror-lint-markers'],
       // theme: 'rubyblue',
       // lint: true
      });

      this.jsonEditor.setValue(this.value);
      this.jsonEditor.on('change', cm => {
        this.$emit('changed', cm.getValue())
        this.$emit('input', cm.getValue())
      });
      this.jsonEditor.on('gutterClick', (cm, n) => {

      let info = cm.lineInfo(n)
      //cm.setGutterMarker(n, "breakpoints", info.gutterMarkers ? null : makeMarker());
      let ln = info.text
      if (/^\s*$/.test(ln)) return

      let new_ln
      if (/^#/.test(ln)) {
        new_ln = ln.replace(/^#\s*/, '')
      } else {
        new_ln = '# ' + ln
      }
      this.jsonEditor.getDoc()
        .replaceRange(new_ln, {line: info.line, ch: 0}, {
          line: info.line,
          ch: ln.length
        })
      //app.caculateHosts();
    })
    },
    methods: {
      getValue() {
        return this.jsonEditor.getValue()
      }
    }
  }
</script>

<style>
.CodeMirror {
  height: 100%;
}
  .cm-s-default .cm-comment {
    color: #090;
  }

  .cm-s-default .cm-ip {
    color: #00a;
    font-weight: bold;
  }

  .cm-s-default .cm-hl {
    background: #ff0;
  }

  .CodeMirror-gutters {
    border-right: none;
    padding-right: 6px;
    background: #fafafa;
    border-radius: 4px 0 0 4px;
  }

  .CodeMirror-linenumber {
    cursor: pointer;
    font-size: 12px;
  }
.json-editor .cm-s-rubyblue span.cm-string {
  color: #F08047;
}
</style>
