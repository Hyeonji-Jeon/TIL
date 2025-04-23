import React from 'react';
import TodoAddComponent from "~/components/todo/TodoAdd";

function TodoAddPage() {

    return (
        <div>
            <div className={'text-4xl'}>Todo Add Page</div>


            <TodoAddComponent/>

        </div>
    );
}

export default TodoAddPage;