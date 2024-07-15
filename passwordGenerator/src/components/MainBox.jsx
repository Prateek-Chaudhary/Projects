import PasswordField from "./PasswordField";

function MainBox() {
  return (
    <div className='w-fit mx-auto mt-48 bg-white rounded-xl text-center px-10'>
      <h1 className='text-5xl font-semibold py-5'>Password Generator</h1>
      < PasswordField />
    </div>
  )
}

export default MainBox;