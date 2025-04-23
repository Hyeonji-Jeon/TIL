import { CurrentUserInfo } from "@/types/global";
import { cookies } from "next/headers";
import { verifyJWT } from "./jwtUtil";

export async function getUser(): Promise<CurrentUserInfo  | null> {    
  const cookieObj = await cookies()    
  const accessToken = cookieObj.get("access-token")?.value;    
  const refreshToken = cookieObj.get("refresh-token")?.value;    
  const mid = cookieObj.get("mid")?.value;    
  
  if (!accessToken) return null;    
  
  const claims =  await verifyJWT(accessToken) ;

  if(claims?.mid !== mid) {
    return null
  }

  return {mid: mid ,accessToken,refreshToken}
}

