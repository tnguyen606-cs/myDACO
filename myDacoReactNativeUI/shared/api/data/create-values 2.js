export const createValues = async ({
  values,
  table,
}) => {
  let result = {
    data: null,
    result: false,
  };

  try {
    const res = await fetch(`https://cms.sizze.io/value/create/`, {
      credentials: "include",
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        table,
        values,
      }),
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