import axios from "axios";

function TodoList() {

    const handleClick = async () => {

        const res = await axios.get('http://122.34.51.94:8090/api/v1/todos');

        console.log(res)
    }

    return (
        <div onClick={handleClick}>
            LIST
        </div>
    );
}

export default TodoList;