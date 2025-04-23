import {create} from "zustand";


export type Store = {
    count: number
    inc: () => void
}

export const useTodoStore = create<Store>()((set) => ({
    count: 1,
    inc: () => set((state) => ({ count: state.count + 1 })),
}))