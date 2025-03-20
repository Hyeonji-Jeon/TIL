import React, {useState} from 'react';
import {login} from "../../slices/loginSlice.jsx";
import {useDispatch} from "react-redux";

function LoginComponent() {

    const [uid, setUid] = useState('')

    const dispatch = useDispatch()

    return (
        <div>
            <h1>Login Component</h1>
            <input type='text' value={uid} onChange={ e => {
                setUid(e.target.value)
            }}/>

            <button onClick={ () => {
                dispatch( login(uid))
            }}>LOGIN</button>

        </div>
    );
}

export default LoginComponent;