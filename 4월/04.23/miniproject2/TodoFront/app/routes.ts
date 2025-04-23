// app/routes.ts
import { type RouteConfig, index, route } from "@react-router/dev/routes";

export default [
  // ① 홈(index) · About
  index("routes/home.tsx"),
  route("/about", "routes/about.tsx"),

  // ② 로그인 페이지 ── ★ 이 한 줄을 꼭 넣어 주세요
  route("/member/login", "routes/member/login.tsx"),

  // 회원가입 페이지
  route("/member/signup", "routes/member/signup.tsx"),

  // ③ Todo (예: 인증이 필요하면 RequireAuth 레이아웃으로 감쌀 수도 있음)
  route(
    "/todo",
    "layout/todoLayout.tsx",
    [
      route("", "routes/todo/TodoList.tsx"),
      route("read", "routes/todo/TodoRead.tsx")
    ]
  ),


] satisfies RouteConfig;
