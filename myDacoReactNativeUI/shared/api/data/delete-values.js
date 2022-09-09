export const deleteValues = async ({
  valueId,
}: {
  valueId: string,
}) => {
  const result = {
    data: null,
    result: false,
  };

  try {
    const res = await fetch(`https://cms.sizze.io/value/${valueId}/delete/`, {
      credentials: "include",
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
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
