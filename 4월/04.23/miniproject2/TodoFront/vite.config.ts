import { reactRouter } from "@react-router/dev/vite";
import tailwindcss from "@tailwindcss/vite";
import { defineConfig } from "vite";
import tsconfigPaths from "vite-tsconfig-paths";

export default defineConfig({
  plugins: [
                // 1) React(JSX/TSX) & Fast Refresh 지원
    reactRouter(), 
        // 2) React Router Dev 지원 (선택)
    tsconfigPaths(),    // 3) tsconfig paths alias 지원
    tailwindcss(),      // 4) Tailwind CSS 통합
  ],
  server: {
    proxy: {
      // /api로 시작하는 요청은 모두 8080(Spring 서버)로 보냄
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
    },
  },
});