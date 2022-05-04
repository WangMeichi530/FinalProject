import request from '@/utils/request'

// Access to service information
export function getServer() {
  return request({
    url: '/monitor/server',
    method: 'get'
  })
}
