/**
 * @classdesc dictionary data
 * @property {String} label label
 * @perty {*} value label
 * @property {Object} raw data
 */
export default class DictData {
  constructor(label, value, raw) {
    this.label = label
    this.value = value
    this.raw = raw
  }
}
