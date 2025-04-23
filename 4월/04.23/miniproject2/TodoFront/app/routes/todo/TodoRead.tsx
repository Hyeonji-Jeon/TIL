import React from 'react';
import TodorReadComponent from "~/components/todo/TodoRead";
import {useParams} from "react-router";
import TodoRead from "~/components/todo/TodoRead";

function TodoAddPage() {

    const todoId = useParams();

    return (
        <div>
            <div className={'text-4xl'}>Todo Read Page</div>


            <TodoRead todoId={Number(todoId)}/>

        </div>
    );
}

export default TodoAddPage;