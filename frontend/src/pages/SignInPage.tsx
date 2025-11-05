import { SigninForm } from "@/components/auth/signin-form";

const SignInPage = () => {
  return (
    <div className="bg-[#e8ebed] flex min-h-svh flex-col items-center justify-center p-6 md:p-10">
      <div className="w-full">
        <SigninForm />
      </div>
    </div>
  );
};

export default SignInPage;
