<template>
    <div class="search-box">
        <input 
        type="search" 
        @change="
        $emit('searchMovie', $event.target.value)
        inputText = $event.target.value;
        $event.target.value = ''                // 검색하고 나면 다시 빈 검색창으로
        "
        placeholder="검색어를 입력하세요."
        >
        <button>검색</button>
    </div>
</template>
<script>
export default {
    name: 'SearchBarComponent',
    data() {
        return {
            inputText: '',
        }
    },
    props: {
        data: Array
    },
    watch: {
        inputText(name) {
            // 입력한 영화제목이 데이터에 있는지 확인 
            const findName = this.data.filter(movie => {
                return movie.title.includes(name);     // 같거나 포함되어 있으면
            })
            
            if(findName.length == 0) {
                alert('해당하는 영화가 없습니다;')
            }
            
        }
    }
}
</script>
<style>
.search-box {
    padding: 10px;
    display: flex;
    justify-content: center;
}

.search-box inpput {
    padding: 5px 10px;
}

.search-box button {
    margin: 0;
}
</style>