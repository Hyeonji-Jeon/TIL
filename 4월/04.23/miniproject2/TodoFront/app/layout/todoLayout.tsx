import {useTodoStore} from "~/store/useTodoStore";
import {Link, Outlet} from "react-router";


export default function TodoLayout() {

    const { count } = useTodoStore()

    return (
        <div className="min-h-screen bg-gradient-to-b from-gray-100 to-gray-200">
            <header className="bg-white shadow-md">
                <div className="max-w-4xl mx-auto px-6 py-5 flex justify-between items-center">
                    <h1 className="text-3xl font-bold text-gray-800 flex items-center gap-2">
                        📝 Todo App
                    </h1>

                    <div className="bg-amber-500 text-white text-sm px-4 py-2 rounded-full shadow">
                        COUNT: {count}
                    </div>

                    <nav className="flex gap-3">
                        <Link
                            to="/todo"
                            className="px-4 py-2 rounded-lg text-sm font-medium text-gray-700 hover:bg-gray-200 transition"
                        >
                            📋 Todo List
                        </Link>
                        <Link
                            to="/todo/add"
                            className="px-4 py-2 rounded-lg text-sm font-medium text-white bg-blue-600 hover:bg-blue-700 transition"
                        >
                            ➕ Add Todo
                        </Link>
                    </nav>
                </div>
            </header>

            <main className="max-w-4xl mx-auto px-6 py-8">
                <Outlet />
            </main>
        </div>


    );
}