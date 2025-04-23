import { useState } from "react";
import { useNavigate } from "react-router";
import { signup } from "../../api/memberAPI"; // ← 경로 확인 (routes/member → ../../api)

export default function Signup() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [error, setError] = useState<string | null>(null);

  const navigate = useNavigate();

  const onSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    try {
      await signup({ username, password, email }); // 회원가입 API 호출
      alert("회원가입이 완료되었습니다! 로그인 해주세요.");
      navigate("/member/login");
    } catch (err: any) {
      setError(err.response?.data?.message || "회원가입에 실패했습니다.");
    }
  };

  return (
    <div className="max-w-sm mx-auto mt-20 p-6 bg-white rounded shadow">
      <h1 className="text-2xl font-semibold mb-4">회원가입</h1>

      <form onSubmit={onSubmit} className="space-y-4">
        {/* 아이디 */}
        <div>
          <label className="block mb-1">아이디</label>
          <input
            className="w-full border px-2 py-1 rounded"
            value={username}
            onChange={e => setUsername(e.target.value)}
            required
            autoFocus
          />
        </div>
        {/* 이메일 */}
        <div>
          <label className="block mb-1">이메일</label>
          <input
            type="email"
            className="w-full border px-2 py-1 rounded"
            value={email}
            onChange={e => setEmail(e.target.value)}
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
          회원가입
        </button>
      </form>
    </div>
  );
}
