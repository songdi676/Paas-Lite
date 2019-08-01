<template>
  <div class="components-container" style='height:100vh'>
    <code>jsonEditor is base on  <a href="https://github.com/codemirror/CodeMirror" target="_blank">CodeMirrorr</a>,lint base on json-lint </code>
    <div class="editor-container">
      <hosts-editor ref="jsonEditor" v-model="value"></hosts-editor>
    </div>
  </div>
</template>

<script>
  import hostsEditor from 'components/hostsEditor';
  const jsonData = '';

  export default {
    components: { hostsEditor },
    data() {
      return {
        value: jsonData
      }
    }
  };
</script>

<style scoped>
.editor-container{
  position: relative;
  height: 100%;
}
</style>

