const SERVER = 'http://localhost:8888';

async function api(endpoint: string, config?: RequestInit){
    console.log(`Endpoint: ${SERVER}${endpoint}`)

    const result = await fetch(`${SERVER}${endpoint}`, config)
    return result.json()
}

export default api