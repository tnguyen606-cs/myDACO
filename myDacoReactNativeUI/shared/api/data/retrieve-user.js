export const retrieveUser = async ({storageId, tokenId}) => {
    const result = {
        data: null,
        result: false,
    };

    try {
        const res = await fetch(`https://cms.sizze.io/user/${storageId}/user/retrieve/`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "sizze-user-token": tokenId,
                "Authorization": ""
            },
        });

        if (res.ok) {
            result.data = await res.json();
            result.result = true;
        }
    } catch (e) {
        console.error(e);
    }

    return result;
};