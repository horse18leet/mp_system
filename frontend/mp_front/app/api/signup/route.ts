import {NextResponse, NextRequest} from "next/server";

export async function registration(req: Request) {
    const body = await req.json();

    console.log(body);

    return NextResponse.json({ body });
}