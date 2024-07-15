import { useCallback, useEffect, useRef, useState } from "react";

function PasswordField() {
  let [password, setPassword] = useState("get Password");
  let [length, setLength] = useState(8);
  let [isNumeric, setIsNumeric] = useState(false);
  let [isSpecial, setIsSpecial] = useState(false);
  let passwordRef = useRef(null);

  let changePassword = useCallback(() => {
    let passwordValue = "";
    let values = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    if (isNumeric) values += "1234567890";
    if (isSpecial) values += "!@$&?/<>%#_-=+|";

    for (let i = 1; i <= length; i++) {
      let randomIndex = Math.floor(Math.random() * values.length);
      passwordValue += values.charAt(randomIndex);
    }

    setPassword(passwordValue);
  }, [setPassword, length, isNumeric, isSpecial]);

  useEffect(() => {
    changePassword();
  }, [setPassword, isNumeric, isSpecial, length]);

  let copyPassword = () => {
    window.navigator.clipboard.writeText(password);
    passwordRef.current?.select();
  }

  return (
    <>
      <div className="flex items-center justify-center pb-5">
        <div className="passwordField">
          <input
            readOnly
            ref={passwordRef}
            type="text"
            value={password}
            className="border border-gray-400 w-80 h-9 rounded-md mr-2 outline-none pl-3 font-semibold"
          />
        </div>
        <div className="copyButton">
          <button 
            className="bg-cyan-700 text-xl text-white px-5 h-9 rounded-md ml-3 hover:bg-cyan-800 active:bg-cyan-700"
            onClick={() => copyPassword()}
          >
            Copy
          </button>
        </div>
      </div>
      <div className="length flex justify-around pt-2 pb-5">
        <input
          type="range"
          className="w-72"
          name="length"
          defaultValue={length}
          onChange={(event) => setLength(event.target.value)}
          min={5}
          max={32}
          id="len"
        />
        <label htmlFor="len" className="text-lg">
          Length : {length}
        </label>
      </div>
      <div className="numberSpecial flex justify-between items-center px-3 pb-5">
        <div className="numeric">
          <input
            type="checkbox"
            onChange={() => setIsNumeric((prev) => !prev)}
            name="numeric"
            className="mx-2 size-4"
            id=""
          />
          <label className="text-xl">Numbers</label>
        </div>
        <div className="special">
          <input
            type="checkbox"
            onChange={() => setIsSpecial((prev) => !prev)}
            name="special"
            className="mx-2 size-4"
            id=""
          />
          <label className="text-xl">Special Characters</label>
        </div>
      </div>
    </>
  );
}

export default PasswordField;
