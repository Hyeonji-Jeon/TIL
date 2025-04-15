import React from 'react';
import { getKakaoLoginLink } from "~/api/kakaoAPI";
import { Link } from "react-router";

function LoginPage() {
    const kakaoLink = getKakaoLoginLink();

    return (
        <div className="min-h-screen flex items-center justify-center bg-yellow-50">
            <div className="bg-white rounded-2xl shadow-xl p-10 w-full max-w-md text-center">
                <h1 className="text-3xl font-bold mb-6 text-yellow-600">Welcome Back!</h1>
                <p className="text-gray-500 mb-8">카카오로 로그인 해보세용 ✨</p>

                <Link
                    to={kakaoLink}
                    className="bg-yellow-300 w-16 h-16 rounded-full flex items-center justify-center shadow-md transition duration-300 mx-auto bg-white hover:bg-yellow-100"
                >
                    <img
                        src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
                        alt="Kakao Talk Icon"
                        className="w-10 h-10"
                    />
                </Link>

                <p className="text-sm text-gray-400 mt-4">카카오 로그인</p>
            </div>
        </div>
    );
}

export default LoginPage;
