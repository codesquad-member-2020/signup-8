import {
  REG,
  MSG_CONTAINER,
  SUCCESS_COLOR,
  ID_MSG,
  PSWD1_MSG,
  PSWD1_INVALID_CASE,
  PSWD2_MSG,
  BIRTH_ERR_MSG,
  EMAIL_ERR_MSG,
  PHONE_ERR_MSG,
  pswd1Input
} from "../common/constants.js";
import { isValid, addMsg, addClass, removeClass, showErrMsg } from "../common/util.js";
import { fetchRequest } from "../common/fetchReq.js";

const checkInputName = ({ id, value }) => {
  switch (id) {
    case "id":
      checkId(value);
      break;
    case "pswd1":
      checkPswd1(value);
      break;
    case "pswd2":
      checkPswd2(value);
      break;
    case "yy":
      checkBirth(value);
      break;
    case "email":
      checkEmail(value);
      break;
    case "tel":
      checkPhoneNo(value);
    default:
      break;
  }
};

const checkId = id => {
  if (!isValid(REG.ID, id)) {
    showErrMsg(MSG_CONTAINER.ID, ID_MSG.INVALID);
    return;
  }

  // if (!isUniqueId(id)) {
  //   showErrMsg(MSG_CONTAINER.ID, ID_MSG.OVERLAP);
  //   return;
  // }

  addClass(MSG_CONTAINER.ID, SUCCESS_COLOR);
  addMsg(MSG_CONTAINER.ID, ID_MSG.SUCCESS);
};

const isUniqueId = id => {
  const data = { userId: id };

  fetchRequest("/api/duplicate", data)
    .then(response => response.json())
    .then(suggestionData => {
      console.log(suggestionData);
      return suggestionData;
    });
};

const checkPswd1 = pswd => {
  if (!isValid(REG.PSWD_LEN, pswd)) {
    showErrMsg(MSG_CONTAINER.PSWD, PSWD1_MSG.INVALID_LEN);
    return;
  }

  if (!isValid(REG.UPPER_CASE, pswd)) {
    showErrMsg(MSG_CONTAINER.PSWD, PSWD1_INVALID_CASE.ENG_UP + PSWD1_MSG.INVALID);
    return;
  }

  if (!isValid(REG.DOWN_CASE, pswd)) {
    showErrMsg(MSG_CONTAINER.PSWD, PSWD1_INVALID_CASE.ENG_DOWN + PSWD1_MSG.INVALID);
    return;
  }

  if (!isValid(REG.NUMBER, pswd)) {
    showErrMsg(MSG_CONTAINER.PSWD, PSWD1_INVALID_CASE.NUMBER + PSWD1_MSG.INVALID);
    return;
  }

  if (!isValid(REG.CHARACTOR, pswd)) {
    showErrMsg(MSG_CONTAINER.PSWD, PSWD1_INVALID_CASE.CHARACTOR + PSWD1_MSG.INVALID);
    return;
  }

  addClass(MSG_CONTAINER.PSWD, SUCCESS_COLOR);
  addMsg(MSG_CONTAINER.PSWD, PSWD1_MSG.SUCCESS);
};

const checkPswd2 = pswd2 => {
  if (pswd1Input.value !== pswd2) {
    removeClass(MSG_CONTAINER.PSWD2, SUCCESS_COLOR);
    addMsg(MSG_CONTAINER.PSWD2, PSWD2_MSG.FAIL);
    return;
  }

  addClass(MSG_CONTAINER.PSWD2, SUCCESS_COLOR);
  addMsg(MSG_CONTAINER.PSWD2, PSWD2_MSG.SUCCESS);
};

const isEqualPswd = () => {};

const checkBirth = () => {};

const isValidBirth = () => {};

const checkEmail = () => {};

const isValidEmail = () => {};

const checkPhoneNo = () => {};

const isValidPhoneNo = () => {};

export { checkInputName };
