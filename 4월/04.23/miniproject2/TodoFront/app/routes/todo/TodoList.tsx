import React from 'react';
import TodoListComponent from "~/components/todo/TodoList";

function TodoListPage() {
    return (
        <div className="bg-gray-100 min-h-screen py-6">
            <div className="container mx-auto max-w-3xl bg-white shadow-md rounded-lg p-8">
                <div className="text-center mb-6">
                    <h1 className="text-4xl font-bold text-indigo-600 mb-2">
                        📝 Todo List
                    </h1>
                    <p className="text-gray-500">오늘 해야 할 일들을 확인하고 관리하세요.</p>
                </div>

                <div className="mb-4">
                   <TodoListComponent />
                </div>

                <div className="text-center text-gray-500 text-sm mt-8">
                    © {new Date().getFullYear()} ToDo
                </div>



            </div>
        </div>
    );
}

export default TodoListPage;