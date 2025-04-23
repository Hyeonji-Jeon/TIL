
"use client"


import { loginAction } from "@/app/member/actions"

import { CurrentUserInfo } from "@/types/global"
import { useRouter } from "next/navigation"
import { useActionState, useEffect } from "react"




const initState:CurrentUserInfo = {
  mid:'',
  accessToken: '',
  refreshToken: ''
}

const loginFn = async (state:CurrentUserInfo, formData:FormData) => {

  const mid = formData.get("mid") as string
  const mpw = formData.get("mpw") as string

  console.log(mid, mpw, "mid", "mpw")

  const {accessToken, refreshToken} = await loginAction(mid,mpw)

  return {mid, accessToken, refreshToken}

}



export default function LoginComponent() {


  const [state, action, isFending] = useActionState(loginFn, initState )


  return (

<div className="w-full max-w-sm bg-white rounded-2xl shadow-md p-8">
      <h2 className="text-2xl font-bold text-center mb-6 text-gray-800">로그인</h2>

      {isFending && <div>로그인 처리중 </div>}

      {state.accessToken && <div>Login 성공</div>}

      <form className="space-y-5" action={action}>
        <div>
          <label htmlFor="mid" className="block text-sm font-medium text-gray-700">
            아이디 (mid)
          </label>
          <input
            type="text"
            id="mid"
            name="mid"
            required
            className="mt-1 w-full px-4 py-2 border border-gray-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <div>
          <label htmlFor="mpw" className="block text-sm font-medium text-gray-700">
            비밀번호 (mpw)
          </label>
          <input
            type="password"
            id="mpw"
            name="mpw"
            required
            className="mt-1 w-full px-4 py-2 border border-gray-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
        </div>
        <button
          type="submit"
          className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded-xl transition"
        >
          로그인
        </button>
      </form>
      <p className="text-sm text-center text-gray-500 mt-4">
        아이디나 비밀번호를 잊으셨나요?
      </p>
    </div>
  )
} 