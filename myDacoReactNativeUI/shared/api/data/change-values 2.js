export const changeValues = async ({
  valueId,
  data,
}) => {
  const result = {
    data: null,
    result: false,
  };
  console.log(data);
  try {
    const res = await fetch(`https://cms.sizze.io/value/${valueId}/update/`, {
      credentials: "include",
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        ...data,
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