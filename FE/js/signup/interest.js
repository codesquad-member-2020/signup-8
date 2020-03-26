import { qsAll$ } from "../common/util.js";
import { tagContainer, favorInput, KEYCODE } from "../common/constants.js";

let tags = [];

const createTag = label => {
  return `<div class="tag"><span>${label}</span><i class="material-icons" data-item="${label}">close</i></div>`;
};

const clearTags = () => {
  qsAll$(".tag").forEach(tag => {
    tag.parentElement.removeChild(tag);
  });
};

const deleteTag = ({ target }) => {
  if (target.tagName === "I") {
    const tagLabel = target.getAttribute("data-item");
    const index = tags.indexOf(tagLabel);
    tags = [...tags.slice(0, index), ...tags.slice(index + 1)];
    addTags();
  } else if (event.keyCode === KEYCODE.BACKSPACE && favorInput.value === "" && tags.length > 0) {
    const inputString = tags.pop();
    addTags();
    favorInput.value = inputString;
  }
};

const addTags = () => {
  clearTags();

  let tagsHTML = "";
  tags.slice().forEach(tag => {
    tagsHTML += createTag(tag);
  });
  tagContainer.insertAdjacentHTML("afterbegin", tagsHTML);
};

const onKeyUpEvent = ({ target }) => {
  const targetValue = target.value.slice(0, -1);

  if (targetValue.includes(",")) {
    favorInput.value = "";
  } else if (event.keyCode === KEYCODE.COMMA && targetValue.length > 0) {
    tags.push(targetValue);

    addTags();
    favorInput.value = "";
  }
};

const registerKeyUpEventListener = () => {
  favorInput.addEventListener("keyup", onKeyUpEvent);
  favorInput.addEventListener("keyup", deleteTag);
  tagContainer.addEventListener("click", deleteTag);
};

export { registerKeyUpEventListener };