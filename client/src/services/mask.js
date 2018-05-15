
export const dateBrMask = (date) => {
  return date.replace(/(\d{4})-(\d\d)-(\d\d)/g, '$3/$2/$1')
}
