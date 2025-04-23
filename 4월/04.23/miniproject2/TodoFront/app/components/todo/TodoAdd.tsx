import { useState } from "react";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useNavigate } from "react-router";
import { testTodoAdd, testTodoAddForm } from "~/api/todoAPI";

function TodoAddComponent() {
    const [title, setTitle] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const queryClient = useQueryClient();
    const navigate = useNavigate();

    const mutation = useMutation({
        mutationFn: () => {
            const data = testTodoAddForm(title);
            return testTodoAdd(data);
        },
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ["todos"] });
            navigate("/todo");
        },
        onError: (error: any) => {
            if (error.response?.status === 404) {
                setErrorMessage("백엔드 API(/api/todo)를 찾을 수 없습니다. 서버를 확인하세요.");
            } else if (error.response?.status === 400) {
                setErrorMessage("잘못된 요청 데이터입니다. 입력을 확인하세요.");
            } else {
                setErrorMessage(error.response?.data?.error || "요청 중 오류가 발생했습니다.");
            }
        },
    });

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (!title.trim()) {
            setErrorMessage("제목을 입력하세요.");
            return;
        }
        setErrorMessage("");
        mutation.mutate();
    };

    return (
        <div className="p-6">
            <div className="text-4xl font-bold mb-6">Todo Add Component</div>
            {errorMessage ? (
                <div className="text-2xl text-red-600">{errorMessage}</div>
            ) : (
                <div className="text-2xl">
                    <form onSubmit={handleSubmit} className="space-y-4">
                        <div>
                            <label className="block text-lg font-medium mb-1">Title:</label>
                            <input
                                type="text"
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                                placeholder="Enter todo title"
                                className="w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                            />
                        </div>
                        <button
                            type="submit"
                            className="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700"
                        >
                            Add Todo
                        </button>
                    </form>
                </div>
            )}
        </div>
    );
}

export default TodoAddComponent;