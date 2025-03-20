import React from 'react';
import useCounterStore from "../../stores/useCounterStore.jsx";

function Count2Double() {

    const {makeDouble} = useCounterStore()

    return (
        <div>
            <button onClick={makeDouble}>DOUBLE</button>
        </div>
    );
}

export default Count2Double;