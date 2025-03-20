import axios from "axios";


function TodoAdd() {

    async function handleClick () {

        const data = {title:'React Todo Test',writer:'jhj'}

        const res = await axios.post('http://localhost:8090/api/v1/todos', data)

        console.log(res)
    }

    return (
        <div>
            <button onClick={handleClick}>SEND</button>
        </div>
    );
}

export default TodoAdd;
