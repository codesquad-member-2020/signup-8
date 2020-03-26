export const qs$ = selector => document.querySelector(selector);
export const qsAll$ = selector => document.querySelectorAll(selector);
export const addClass = (target, className) => target.classList.add(className);
export const removeClass = (target, className) => target.classList.remove(className);
export const addMsg = (target, msg) => (target.innerText = msg);
export const isValid = (regex, str) => regex.test(str);
