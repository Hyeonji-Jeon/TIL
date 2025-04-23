// api/memberAPI.ts
import axios from "axios";

/** ------------------------------------------------------------------
 *  공통 axios 인스턴스
 * ------------------------------------------------------------------*/
const api = axios.create({
  baseURL: "http://localhost:8080", // 백엔드 주소
  withCredentials: true,            // 세션(JSESSIONID) 쿠키 전송
});

/** ------------------------------------------------------------------
 *  로그인
 * ------------------------------------------------------------------*/
/**
 * @param username 사용자 아이디
 * @param password 비밀번호
 * @returns 로그인 성공 시 사용자 DTO(또는 빈 body)
 */
export async function login(username: string, password: string) {
  const res = await api.post("/api/v1/member/login", { mid : username, mpw : password });
  return res.data;
}

/** ------------------------------------------------------------------
 *  로그아웃
 * ------------------------------------------------------------------*/
export async function logout() {
  await api.post("/member/logout");
}

/** ------------------------------------------------------------------
 *  현재 로그인 사용자 정보
 * ------------------------------------------------------------------*/
export async function fetchMe() {
  const res = await api.get("/auth/me"); // 200 OK or 401/403
  return res.data;
}
/** -----------------------------------------------------------------
 *  회원가입
 * --------------------------------------------------------------*/
export async function signup({ username, password, email }: { username: string, password: string, email: string }) {
  // 백엔드 요구: mid, mpw, email
  return axios.post("/api/v1/member/signup", {
    mid: username,
    mpw: password,
    email: email
  });
}
