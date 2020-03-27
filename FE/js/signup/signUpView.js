import { inputContainer } from "../common/constants.js";
import { addClass, removeClass } from "../common/util.js";
import { checkInputName } from "./validation.js";

const registerFocusListener = () => {
  inputContainer.addEventListener("click", ({ target }) => {
    if (target.parentElement.className.includes("ps_box")) {
      addClass(target.parentElement, "focus");
    }
  });
  inputContainer.addEventListener("focusout", ({ target }) => {
    removeClass(target.parentElement, "focus");
    checkInputName(target);
  });
};

export { registerFocusListener };
