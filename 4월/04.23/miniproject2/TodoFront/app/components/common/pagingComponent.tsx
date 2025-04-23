import {useNavigate, useSearchParams} from "react-router";


function PagingComponent({serverData}: {serverData: PageResponse<any>}){

    const {pageNumList, prev, next, prevPage, nextPage, current} = serverData

    const [searchParams] = useSearchParams();
    const navigate = useNavigate();

    const handlePageChange = (newPage: number) => {
        const params = new URLSearchParams(searchParams.toString());
        params.set("page", String(newPage));
        navigate(`?${params.toString()}`);
    };

    return (
        <div className="flex justify-center py-4">
            <ul className="flex space-x-4">
                {/* Prev Page Button */}
                {prev && (
                    <li
                        key={prevPage}
                        className="px-4 py-2 rounded-lg bg-gradient-to-r bg-gray-200  text-gray-700 cursor-pointer transition duration-300 transform hover:scale-105"
                        onClick={() => handlePageChange(prevPage)}
                    >
                        Prev
                    </li>
                )}

                {/* Page Numbers */}
                {pageNumList.map((page) => (
                    <li
                        key={page}
                        className={`px-4 py-2 rounded-lg text-sm font-medium text-gray-700 cursor-pointer transition duration-300 transform hover:scale-105 ${
                            current !== page
                                ? "bg-gray-200 hover:bg-gray-300"
                                : "bg-amber-500 text-white"
                        }`}
                        onClick={() => handlePageChange(page)}
                    >
                        {page}
                    </li>
                ))}

                {/* Next Page Button */}
                {next && (
                    <li
                        key={nextPage}
                        className="px-4 py-2 rounded-lg bg-gradient-to-r bg-gray-200  text-gray-700 cursor-pointer transition duration-300 transform hover:scale-105"
                        onClick={() => handlePageChange(nextPage)}
                    >
                        Next
                    </li>
                )}
            </ul>
        </div>
    );
}

export default PagingComponent;
