<template>
  <Navbar />
  <SearchBar
  :data="data_temp"
  @searchMovie="searchMovie($event)"
  />
  <p>
    <button @click="showAllMovie">전체보기</button>
  </p>
  <Movies 
  :data="data_temp" 
  @openModal="isModal = true; selectedMovie = $event" 
  @increseLike="increseLike($event)"
  />
  <Modal 
  :data="data" 
  :isModal="isModal" 
  :selectedMovie="selectedMovie"
   @closeModal="isModal = false" 
   />
</template>

<script>
import data from './assets/movies';
import Navbar from './components/Navbar.vue';
import Modal from './components/Modal.vue';
import Movies from './components/Movies.vue';
import SearchBar from './components/SearchBar.vue';

export default {
  name: 'App',    // 컴포넌트명
  data() {
    return {
      isModal: false,
      data: data,         // 원본
      data_temp: [...data],      // 사본  // ...data  => 원래 있던 데이터를 복사
      selectedMovie: 0,
    }
  },
  methods: {
    increseLike(id) {
      //this.data[i].like += 1;  => 이 방식은 movie.id가 0, 1, 2 였기 때문에 동작했던 거고, id를 다르게 줬을 시에는 오류가 났을 것임.
      this.data.find(movie => {
        if(movie.id == id){
          movie.like += 1;
        }
      })
    },
    searchMovie(title){
      // 영화제목이 포함된 데이터를 가져옴
      this.data_temp = this.data.filter(movie => {
        return movie.title.includes(title);
      })
    },
    showAllMovie(){
      // 전체 영화 조회 
      this.data_temp = this.data;
    }
  }, 
  components: {
    Navbar: Navbar,
    Modal: Modal,
    Movies: Movies,
    SearchBar: SearchBar
  }
}
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
}

body {
  max-width: 768px;
  margin: 0 auto;
  padding: 20px;
}

h1,
h2,
h3 {
  margin-bottom: 1rem;
}

p {
  margin-bottom: 0.5rem;
}

button {
  margin-right: 10px;
  margin-top: 1rem;
}

.item {
  width: 100%;
  border: 1px solid #ccc;
  display: filex;
  margin-bottom: 20px;
  padding: 1rem;
}

.item figure {
  width: 30%;
  margin-right: 1rem;
}

.item img {
  width: 100%;
}

.item .info {
  width: 100%;
}

.modal {
  background: rgba(0, 0, 0, 0.7);
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal .inner {
  background: #fff;
  width: 80%;
  padding: 20px;
  border-radius: 10px;
}
</style>
