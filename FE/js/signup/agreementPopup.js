import {} from "../common/constants.js";
import { qs$, addClass, removeClass } from "../common/util.js";

const visiblePopUp = () => {
  addClass(qs$(".modal-content-bg"), "active");
  addClass(qs$(".modal-content-wrap"), "active");
};

const invisiblePopUP = () => {
  removeClass(qs$(".modal-content-bg"), "active");
  removeClass(qs$(".modal-content-wrap"), "active");
};

const checkReading = textBox => {
  checkReading.read = textBox.scrollHeight - textBox.scrollTop === textBox.clientHeight;
  if (!checkReading.read) return;

  addClass(qs$(".btn-agree"), "active");
  qs$(".btn-agree").removeAttribute("disabled");
  qs$(".btn-agree").addEventListener("click", agreeClickEventListener);
};

const agreeClickEventListener = () => {
  invisiblePopUP();
  qs$('input[type="checkbox"]').checked = true;
};

const registerPopUpEvent = () => {
  qs$(".agreement").addEventListener("click", visiblePopUp);
  qs$(".close").addEventListener("click", invisiblePopUP);
  qs$(".modal-body").addEventListener("scroll", ({ target }) => checkReading(target));
};

export { registerPopUpEvent };
