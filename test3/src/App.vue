<template>
  <div class="header">
    <ul class="header-button-left">
      <li @click="step--">Cancel</li>
    </ul>
    <ul class="header-button-right">
      <li v-if="step==1" @click="step++">Next</li>
      <li v-if="step==2" @click="save">Save</li>
    </ul>
    <img src="./assets/logo.png" class="logo" />
  </div>

  <ContainerPage :postData="postData" :step="step" :fileurl="fileurl" @write="write = $event" />

  <button v-if="step!=3" @click="getMore">더보기</button>

  <div v-if="step!=3" class="footer">
    <ul class="footer-button-plus">
      <input @change="upload" type="file" id="file" class="inputfile" />
      <label for="file" class="input-plus">+</label>
    </ul>
 </div>
</template>

<script>
import ContainerPage from './components/ContainerPage.vue'
import data from './assets/data.js'

export default {
  name: 'App',
  data(){
        return{
          cnt:0,
          step:3,
          fileurl:'',
          write:'',
          postData:data,
          filtername:'',
        }
    },
    methods:{
      getMore(){
        this.$store.dispatch('more', this.$store.state.morecnt)
        .then(()=>{
          let array = this.$store.state.moredata;
          this.postData.push(array);
        });
      },
      upload(e){
        let file = e.target.files;
        this.fileurl = URL.createObjectURL(file[0]);
        this.step = 1;
      },
      save(){
        var addData = {
          name: "Sonny",
          userImage: "https://placeimg.com/100/100/tech",
          postImage: this.fileurl,
          likes: 0,
          date: "May 16",
          liked: false,
          content: this.write,
          filter: this.filtername
        }
        this.postData.unshift(addData);
        this.step = 0;
      }
    },
    components: {
      ContainerPage:ContainerPage,
    },
    mounted(){
      this.emitter.on('filter', (a)=>{this.filtername = a; });
    }
}
</script>

<style>
body {
  margin: 0;
}
ul {
  padding: 5px;
  list-style-type: none;
}
.logo {
  width: 22px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}
.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}
.header-button-left {
  color: skyblue;
  float: left;
  width: 50px;
  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}
.header-button-right {
  color: skyblue;
  float: right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
}
.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}
.footer-button-plus {
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}
.sample-box {
  width: 100%;
  height: 600px;
  background-color: bisque;
}
.inputfile {
  display: none;
}
.input-plus {
  cursor: pointer;
}
#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>
