import { cn } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useAuthStore } from "@/stores/useAuthStore";
import { useNavigate } from "react-router";

const signInSchema = z.object({
  username: z.string().min(3, "Tên đăng nhập phải có ít nhất 3 ký tự"),
  password: z.string().min(6, "Mật khẩu phải có ít nhất 6 ký tự"),
});

type SignInFormValues = z.infer<typeof signInSchema>;

export function SigninForm({
  className,
  ...props
}: React.ComponentProps<"div">) {
  const { signIn } = useAuthStore();
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<SignInFormValues>({
    resolver: zodResolver(signInSchema),
  });

  const onSubmit = async (data: SignInFormValues) => {
    const { username, password } = data;
    await signIn(username, password);
    navigate("/");
  };

  return (
    <div className="min-h-screen bg-[#e8ebed] flex items-center justify-center p-5">
      <Card className="overflow-hidden p-0 border-0 shadow-none max-w-[900px] w-full rounded-none bg-transparent">
        <CardContent className="grid p-0 md:grid-cols-2 bg-white rounded-[40px] overflow-hidden h-[579px]">
          {/* Left Side - Sign In Form */}
          <form
            className="p-8 md:px-12 md:py-12 bg-white flex flex-col justify-center relative z-10"
            onSubmit={handleSubmit(onSubmit)}
          >
            <div className="flex flex-col gap-5 max-w-[360px] mx-auto w-full">
              {/* header - logo */}
              <div className="flex flex-col items-center text-center gap-3 mb-2">
                {/* Bookworm Logo */}
                <div className="mb-3">
                  <img
                    src="/logo.svg"
                    alt="BookWorm Logo"
                    className="w-24 h-24 object-contain"
                  />
                </div>

                <h1 className="text-[32px] font-normal text-gray-900">
                  Chào mừng quay lại !!
                </h1>
                <p className="text-gray-600 text-[15px]">
                  Vui lòng nhập thông tin đăng nhập
                </p>
              </div>

              {/* username */}
              <div className="flex flex-col gap-1">
                <Input
                  type="text"
                  id="username"
                  placeholder="Tên đăng nhập"
                  className="h-[50px] rounded-full border-gray-300 px-6 text-[15px] focus-visible:ring-1 focus-visible:ring-gray-400 focus-visible:border-gray-400"
                  {...register("username")}
                />
                {errors.username && (
                  <p className="text-red-500 text-xs px-4">
                    {errors.username.message}
                  </p>
                )}
              </div>

              {/* password */}
              <div className="flex flex-col gap-1">
                <Input
                  type="password"
                  id="password"
                  placeholder="Mật khẩu"
                  className="h-[50px] rounded-full border-gray-300 px-6 text-[15px] focus-visible:ring-1 focus-visible:ring-gray-400 focus-visible:border-gray-400"
                  {...register("password")}
                />
                {errors.password && (
                  <p className="text-red-500 text-xs px-4">
                    {errors.password.message}
                  </p>
                )}
              </div>

              {/* forgot password */}
              <div className="text-left -mt-2">
                <a
                  href="#"
                  className="text-[14px] text-gray-700 hover:text-black transition-colors font-normal"
                >
                  Quên mật khẩu?
                </a>
              </div>

              {/* nút đăng nhập */}
              <Button
                type="submit"
                className="w-full h-[50px] mt-2 rounded-full bg-black hover:bg-gray-800 text-white font-medium text-[15px] transition-colors uppercase tracking-wide"
                disabled={isSubmitting}
              >
                {isSubmitting ? "ĐANG ĐĂNG NHẬP..." : "ĐĂNG NHẬP"}
              </Button>
            </div>
          </form>

          {/* Right Side - BookWorm Library Branding */}
          <div className="bg-black relative hidden md:flex flex-col items-center justify-center p-12 text-white rounded-r-[40px]">
            <div className="flex flex-col items-center text-center">
              {/* Logo */}
              <div className="mb-8">
                <img
                  src="/logo.svg"
                  alt="BookWorm Logo"
                  className="w-56 h-56 object-contain filter invert"
                />
              </div>

              {/* Brand Text */}
              <h2 className="text-[42px] font-light tracking-tight mb-0 leading-none">
                Nobita
              </h2>
              <p className="text-[14px] tracking-[0.35em] mb-16 mt-1 opacity-90 uppercase font-light">
                LIBRARY
              </p>

              {/* Sign Up Prompt */}
              <p className="text-[15px] mb-5 opacity-95 font-light">
                Mới tham gia? Đăng ký ngay.
              </p>

              <Button
                variant="outline"
                className="rounded-full border-2 border-white bg-transparent text-white hover:bg-white hover:text-black px-16 h-[50px] font-medium text-[15px] transition-all uppercase tracking-wide"
                onClick={() => (window.location.href = "/signup")}
              >
                ĐĂNG KÝ
              </Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
