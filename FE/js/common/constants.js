import { qs$ } from "../common/util.js";

export const inputContainer = qs$(".container");
export const tagContainer = qs$(".ps_box.int_favor");
export const favorInput = qs$(".int_favor input");

export const KEYCODE = {
  BACKSPACE: 8,
  COMMA: 188
};

export const VALID_REGEX = {
  ID: /^[a-z0-9][a-z0-9_\-]{5,20}$/,
  PSWD: /^[A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,16}$/,
  EMAIL: /^(([^<>()[\]\\.,;:\s@\"]+(\.[^()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
  P_NUM: /^010\d{3,4}\d{4}$/
};

export const ID_MSG = {
  SUCCESS: "사용 가능한 아이디입니다.",
  INVALID: "5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다.",
  OVERLAP: "이미 사용중인 아이디입니다."
};

export const PSWD1_MSG = {
  SUCCESS: "안전한 비밀번호입니다.",
  INVALID_LEN: "8자 이상 16자 이하로 입력해주세요.",
  INVALID: `를 최소 1자 이상 포함해주세요.`
};

export const PSWD1_INVALID_CASE = {
  ENG_UP: "영어 대문자",
  ENG_DOWN: "영어 소문자",
  NUMBER: "숫자",
  CHARACTOR: "특수문자"
};

export const PSWD2_MSG = {
  SUCCESS: "비밀번호가 일치합니다.",
  FAIL: "비밀번호가 일치하지 않습니다."
};

export const BIRTH_ERR_MSG = {
  YOUNG_AGE: "만 14세 이상만 가입 가능합니다.",
  WRONG_DATE: "태어난 날짜를 다시 확인해주세요.",
  NOT_SUPPORT_AGE: "태어난 년도 4자리를 정확하게 입력하세요."
};

export const EMAIL_ERR_MSG = "이메일 주소를 다시 확인해주세요.";

export const PHONE_ERR_MSG = "형식에 맞지 않는 번호입니다.";

export const FAVOR_ERR_MSG = "3개 이상의 관심사를 입력하세요.";

const today = new Date();
