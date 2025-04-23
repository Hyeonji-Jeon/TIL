import { useQuery } from "@tanstack/react-query";
import {Link, useSearchParams} from "react-router";
import { testTodoList } from "~/api/todoAPI";
import PagingComponent from "~/components/common/pagingComponent";

function TodoListComponent() {
    const [searchParams] = useSearchParams();

    const pageStr = searchParams.get("page") || "1";
    const sizeStr = searchParams.get("size") || "10";

    console.log("pageStr: ", pageStr, " sizeStr: ", sizeStr);

    const query = useQuery<PageResponse<Todo>>({
        queryKey: ['todo', pageStr, sizeStr],
        queryFn: () => testTodoList(pageStr, sizeStr),
    });

    const { data, error, isFetching } = query;

    if (isFetching) return <div className="text-center py-10">Loading...</div>;
    if (error) return <div className="text-center py-10 text-red-500">Error: {error.message}</div>;

    return (
        <div className="container mx-auto p-5">
            {data?.dtoList && (
                <div>
                    <ul className="space-y-4">
                        {data?.dtoList?.map((todo: Todo) => (
                            <li key={todo.tno}
                                className="bg-white shadow-md rounded-lg p-4 hover:bg-gray-100 transition duration-300"
                            >
                                <Link
                                    to={`/todo/read/${todo.tno}`}
                                    className="flex justify-between items-center"
                                >
                                    <div>
                                        <div className="text-xl font-semibold">{todo.title}</div>
                                        <div className="text-gray-600">{todo.writer}</div>
                                    </div>
                                    {todo.regDate && (
                                        <span className="text-gray-500 ml-2 text-sm">
                                            ({new Date(todo.regDate).toLocaleDateString()})
                                        </span>
                                    )}
                                </Link>
                            </li>
                        ))}
                    </ul>

                    <div className="mt-8">
                        <PagingComponent serverData={data} />
                    </div>
                </div>
            )}
        </div>
    );
}

export default TodoListComponent;
