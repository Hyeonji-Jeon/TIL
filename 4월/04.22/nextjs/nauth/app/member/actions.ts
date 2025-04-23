 "use server"

import { cookies } from "next/headers"
import { createJWT } from "../util/jwtUtil"

export async function loginAction (mid:string, mpw:string) {

  console.log("login action...............")

  const accessToken = await createJWT({mid}, "10m")
  const refreshToken = await  createJWT({mid}, "1d")

  console.log("accessToken",accessToken)
  console.log("refreshToken",refreshToken)

  const cookieObj = await cookies()

  cookieObj.set("access-token", accessToken, {
    path: "/",
    maxAge: 60 * 60, // 1시간
  });

  cookieObj.set("refresh-token", refreshToken, {
      path: "/",
      maxAge: 60 * 60 * 24 * 7 //7days
  });

  cookieObj.set("mid", mid, {
    path: "/",
    maxAge: 60 * 60 * 24 * 7 //7days
  });
  
  return {accessToken, refreshToken}

}
export async function loadByCookie () {

  const cookieObj = await cookies()

  const accessToken = cookieObj.get("access-token")?.value
  
  const refreshToken = cookieObj.get("refresh-token")?.value
  
  const mid = cookieObj.get("mid")?.value

  return {mid,accessToken,refreshToken}
}

