export const getTable = async ({
  tableId,
}: {
  tableId: string
}) => {
  const result = {
    data: null,
    result: false,
  };

  try {
    const res = await fetch(`https://cms.sizze.io/table/${tableId}/retrieve/`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
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