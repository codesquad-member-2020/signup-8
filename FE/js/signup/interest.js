import { qsAll$, addMsg } from "../common/util.js";
import {
  tagContainer,
  favorInput,
  favorMsg,
  KEYCODE,
  EMPTY_STR,
  DEL_BTN,
  MIN_TAG_CNT,
  FAVOR_ERR_MSG
} from "../common/constants.js";

let tags = [];

const createTag = label => {
  return `<div class="tag"><span>${label}</span><i class="material-icons" data-item="${label}">close</i></div>`;
};

const clearTags = () => {
  qsAll$(".tag").forEach(tag => tag.parentElement.removeChild(tag));
};

const deleteTag = ({ target }) => {
  if (target.tagName === DEL_BTN) {
    const tagLabel = target.getAttribute("data-item");
    const index = tags.indexOf(tagLabel);
    tags = [...tags.slice(0, index), ...tags.slice(index + 1)];
    addTags();
  } else if (isBackspaceKeyUpEvent()) {
    const inputString = tags.pop();
    addTags();
    favorInput.value = inputString;
  }
};

const addTags = () => {
  clearTags();

  let tagsHTML = EMPTY_STR;
  tags.slice().forEach(tag => (tagsHTML += createTag(tag)));
  tagContainer.insertAdjacentHTML("afterbegin", tagsHTML);
};

const isBackspaceKeyUpEvent = () => {
  return event.keyCode === KEYCODE.BACKSPACE && favorInput.value === EMPTY_STR && tags.length > 0;
};

const keyupCommaEvent = ({ target }) => {
  const targetValue = target.value.slice(0, -1);

  if (targetValue.includes(",")) {
    favorInput.value = EMPTY_STR;
  } else if (event.keyCode === KEYCODE.COMMA && targetValue.length > 0) {
    tags.push(targetValue);

    addTags();
    favorInput.value = EMPTY_STR;
  }
};

const checkTagCount = () => {
  if (tags.length >= MIN_TAG_CNT) {
    addMsg(favorMsg, EMPTY_STR);
    return;
  }

  addMsg(favorMsg, FAVOR_ERR_MSG);
};

const registerKeyUpEventListener = () => {
  favorInput.addEventListener("keyup", event => {
    keyupCommaEvent(event);
    deleteTag(event);
    checkTagCount(event);
  });
  tagContainer.addEventListener("click", event => {
    deleteTag(event);
    checkTagCount(event);
  });
};

export { registerKeyUpEventListener };
