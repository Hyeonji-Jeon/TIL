interface Todo {
    tno: number,
    title: string,
    writer: string,
    regDate? : Date | null,
    modDate? : Date | null,
    files? : File[] | null
}

interface TodoAdd {
    title: string;
    writer: string;
}

interface PageResponse<T> {
    current: number,
    dtoList: T[],
    next: boolean,
    prev: boolean,
    nextPage: number,
    prevPage: number,
    pageNumList: number[],
    totalCount: number,
    totalPage: number,
    pageRequestDTO: PageRequestDTO
}

interface PageRequestDTO {
    page?: number;
    size?: number;
}

interface PageParam {
    page?: string | number
    size?: string | number
}