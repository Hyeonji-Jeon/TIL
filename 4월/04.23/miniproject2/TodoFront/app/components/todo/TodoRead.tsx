import { useQuery } from "@tanstack/react-query";
import { testTodoRead } from "~/api/todoAPI";

function TodoRead({ todoId }: { todoId: number }) {
    const { isFetching, data, error } = useQuery({
        queryKey: ["todo", todoId],
        queryFn: () => testTodoRead(todoId),
    });

    if (isFetching) return <div>Loading...</div>;
    if (error) return <div>Error: {(error as Error).message}</div>;

    return (
        <div>
            <h1 className="text-4xl">Todo Detail</h1>
            {data && (
                <div className="text-2xl">
                    <p>제목: {data.title}</p>
                    <p>작성자: {data.writer}</p>
                    {data.regDate && (
                        <p>등록일: {new Date(data.regDate).toLocaleDateString()}</p>
                    )}

                </div>
            )}
        </div>
    );
}

export default TodoRead;