// components/member/LoginForm.tsx
import { useState } from "react";
import { useNavigate, useLocation, Link } from "react-router";
import { login } from "../../api/memberAPI";    // ← 경로: components/member → ../.. → api

/**
 * 회원 로그인 폼 컴포넌트
 *
 * 사용 예)
 *   <LoginForm />
 *
 * 로그인 성공 시 location.state.from(있으면) 또는 "/todo"로 이동합니다.
 */
export default function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError]       = useState<string | null>(null);

  const navigate = useNavigate();
  const location = useLocation();
  const from     = (location.state as any)?.from || "/todo";

  const onSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      await login(username, password);         // 세션 쿠키 발급
      navigate(from, { replace: true });       // 원래 가려던 페이지로
    } catch (err: any) {
      setError(err.response?.data?.message || "로그인에 실패했습니다.");
    }
  };

  return (
    <div className="max-w-sm mx-auto mt-20 p-6 bg-white rounded shadow">
      <h1 className="text-2xl font-semibold mb-4">로그인</h1>

      <form onSubmit={onSubmit} className="space-y-4">
        {/* 아이디 */}
        <div>
          <label className="block mb-1">아이디</label>
          <input
            className="w-full border px-2 py-1 rounded"
            value={username}
            onChange={e => setUsername(e.target.value)}
            required
          />
        </div>

        {/* 비밀번호 */}
        <div>
          <label className="block mb-1">비밀번호</label>
          <input
            type="password"
            className="w-full border px-2 py-1 rounded"
            value={password}
            onChange={e => setPassword(e.target.value)}
            required
          />
        </div>

        {error && <p className="text-red-600">{error}</p>}

        <button
          type="submit"
          className="w-full bg-blue-600 text-white py-2 rounded"
        >
          로그인
        </button>
      </form>
      {/* --- 아래에 회원가입 링크 추가 --- */}
      <div className="mt-4 text-center">
        <span className="text-gray-500">아직 회원이 아니신가요? </span>
        <Link
          to="/member/signup"
          className="text-blue-600 hover:underline font-semibold"
        >
          회원가입
        </Link>
      </div>

    </div>
  );
}
