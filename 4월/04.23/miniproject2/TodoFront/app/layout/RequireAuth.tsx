// app/layout/RequireAuth.tsx
import { Outlet } from "react-router";
import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

export default function RequireAuth() {
  const [checked, setChecked] = useState(false);
  const location = useLocation();

  useEffect(() => {
    // 1) 세션 쿠키(include)와 함께 인증 상태 조회
    fetch("/api/auth/me", { credentials: "include" })
      .then(res => {
        if (res.ok) {
          // 인증된 경우
          setChecked(true);
        } else {
          // 인증 실패(401/403 등)이면 백엔드 로그인 페이지로 리다이렉트
          const redirectUrl = encodeURIComponent(location.pathname);
          window.location.href = `http://localhost:8080/member/login?redirectUrl=${redirectUrl}`;
        }
      })
      .catch(() => {
        // 네트워크 에러 등도 무조건 로그인 페이지로
        const redirectUrl = encodeURIComponent(location.pathname);
        window.location.href = `http://localhost:8080/member/login?redirectUrl=${redirectUrl}`;
      });
  }, [location.pathname]);

  // 아직 인증 체크가 끝나지 않았다면 로딩 UI
  if (!checked) {
    return <div>로딩 중…</div>;
  }

  // 인증 통과하면 하위 라우트(<Outlet>) 렌더
  return <Outlet />;
}
