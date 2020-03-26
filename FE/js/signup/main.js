import { registerKeyUpEventListener } from "./interest.js";
import { registerFocusListener } from "./signUpView.js";

(() => {
  registerKeyUpEventListener();
  registerFocusListener();
})();
