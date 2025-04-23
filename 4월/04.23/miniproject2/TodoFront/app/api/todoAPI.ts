import axios from "axios";

const host = "http://localhost:8080/api/todo";

export async function testTodoList(page: string, size: string) {


        console.log("testTodoList..====================================================")

        const res = await axios.get(`${host}/list?page=${page}&size=${size}`);

        console.log("testTodoList   data:", res.data);

        return res.data;

}

export function testTodoAddForm(title: string) {
    return {
        title,
        completed: false
    };
}

export async function testTodoAdd(data: { title: string; completed: boolean }) {
    console.log("Sending to:", host);
    console.log("Data:", data);
    try {
        const res = await axios.post(host, data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
        console.log("Response:", res.data);
        return res.data;
    } catch (error) {
        console.error("API Error:", error);
        throw error;
    }
}

export async function testTodoRead(tno: number): Promise<Todo> {
    try {
        const res = await axios.get(`${host}/${tno}`);
        console.log("testTodoRead data:", res.data);
        return res.data;
    } catch (error) {
        console.error("Error fetching todo:", error);
        throw error;
    }
}