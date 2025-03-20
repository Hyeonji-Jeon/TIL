import React from 'react';
import useCounterStore from "../../stores/useCounterStore.jsx";
import Count2Double from "./count2double.jsx";

function Count2Ex() {

    const {count, inc, dec} = useCounterStore()

    return (
        <div>
            <h1>Count2 Ex</h1>
            <h1>COUNT: {count} </h1>
            <div>
                <button onClick={() => inc(5)}>PLUS</button>
                <button onClick={() => dec(1)}>MINUS</button>
            </div>

            <Count2Double></Count2Double>

        </div>
    );
}

export default Count2Ex;