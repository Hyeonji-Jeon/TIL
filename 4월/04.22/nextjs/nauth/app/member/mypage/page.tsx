"use client"


import useLoginHook from "@/app/hooks/useLoginHook"


export default function MyPage() {

  const {mid, accessToken, refreshToken} = useLoginHook()


  return (
    <div>
 
      
      <div>My Page Only for User {mid} </div>
      <div>Access Token {accessToken} </div>
      <div>Refresh Token {refreshToken} </div>
      
    </div>
  )
}